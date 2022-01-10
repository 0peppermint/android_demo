package com.demo.multifragment.someuifragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.demo.multifragment.R
import com.demo.multifragment.someuifragment.marqutee.*
import kotlinx.android.synthetic.main.fragment_my_some_ui.*
import android.util.DisplayMetrics
import android.view.animation.PathInterpolator
import androidx.recyclerview.widget.LinearSmoothScroller
import com.demo.core.utils.MainThreadRunner
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import io.reactivex.disposables.CompositeDisposable


class SomeUiFragment: Fragment() {

    private var rootView: View? = null
    private var index = 1
    private var mFlingObserver : Disposable? = null
    private var isFling = false
    private var compositeDisposable = CompositeDisposable()

    private var startFlingg = false

    private var observer = object : Observer<Long>{
        override fun onSubscribe(d: Disposable) {

        }

        override fun onNext(t: Long) {
            MainThreadRunner.runInMainThread {
                Log.d("zyc", "$t $index")
                dealFlingValueWithRecycleView()
                dealFlingValueWithViewPager()
                index = index % 4 + 1
            }
        }

        override fun onError(e: Throwable) {
            Log.e("zyc", "${e.message}")
        }

        override fun onComplete() {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_my_some_ui, container, false)
        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            Log.d("zyc", "SomeUiFragment onCreate with recovery")
        } else {
            Log.d("zyc", "SomeUiFragment onCreate with no recovery")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 这里是recycleview的写法
        vp_recv_event.layoutManager = object : LinearLayoutManager(context, VERTICAL, false){
            override fun smoothScrollToPosition(
                recyclerView: RecyclerView,
                state: RecyclerView.State?,
                position: Int
            ) {
                val smoothScroller: LinearSmoothScroller =
                    object : LinearSmoothScroller(recyclerView.context) {
                        // 返回：滑过1px时经历的时间(ms)。
                        override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                            return 170f / displayMetrics.densityDpi
                        }
                    }
                smoothScroller.targetPosition = position
                startSmoothScroll(smoothScroller)
            }

        }
        vp_recv_event.adapter = MarquteeRecvAdapter(mutableListOf("123", "456", "789", "666", "123", "456"))
        vp_recv_event.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE && index == 1) {
                    vp_recv_event.scrollToPosition(0)
                }
            }
        })
        // viewPager写法
        vp_event.adapter = MarquteeAdapter(mutableListOf("123", "456", "789", "666", "123", "456"))
        vp_event.orientation = ViewPager2.ORIENTATION_VERTICAL
        vp_event.setPageTransformer(MarquteeTransformer())
        vp_event.offscreenPageLimit = 3
        vp_event.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                if (state == ViewPager2.SCROLL_STATE_IDLE && index == 1) {
                    vp_event.setCurrentItem(1, false)
                }
            }
        })

        //实验一下viewpager2
        expRecyclerView()

        vp_recv_event.scrollToPosition(0)
        vp_fake_drag_recv.scrollToPosition(0)
        vp_event.currentItem = 1

        index = 1

        btn_marqutee.setOnClickListener{
            if (!isFling) startFling() else stopFling()
            isFling = !isFling
            startFlingg = !startFlingg
        }
    }
    override fun onResume() {
        super.onResume()
        bll_blur.startBlur()
        Log.d("zyc", "SomeUiFragment onResume")
    }

    override fun onPause() {
        super.onPause()
        bll_blur.pauseBlur()
        Log.d("zyc", "SomeUiFragment onPause")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("zyc", "SomeUiFragment onDetach")
    }

    override fun onStop() {
        super.onStop()
        Log.d("zyc", "fragmentChild1 onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("zyc", "fragmentChild1 onDestory")
    }

    private fun startFling() {
        val aa = Observable.interval(1, 4, TimeUnit.SECONDS, Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                MainThreadRunner.runInMainThread {
                    Log.d("zyc", "$it $index")
                    dealFlingValueWithRecycleView()
                    dealFlingValueWithViewPager()
                    index = index % 4 + 1
                }
            },{
                Log.e("zyc", "gg")
            })
        compositeDisposable.add(aa)
    }

    private fun stopFling() {
        compositeDisposable.clear()
    }


    private fun dealFlingValueWithRecycleView() {
        vp_recv_event.smoothScrollToPosition(index + 1)
        vp_fake_drag_recv.setFakeDrag(index + 1, 1000)
        // 尝试了网上的https://toutiao.io/posts/vr9ltrp/preview 并没有用
//        vp_fake_drag_recv.smoothScrollToPosition(index + 1, 2000, PathInterpolator(0.65f,0f,0.35f,1f))
    }

    private fun dealFlingValueWithViewPager() {
//        ViewPager2SlowScrollHelper(vp_event, 2000).setCurrentItem(index)
        vp_event.setFakeDrag(index + 1, 1000)
    }

    private fun expRecyclerView(){
        vp_fake_drag_recv.layoutManager = object : LinearLayoutManager(context, VERTICAL, false){}
        vp_fake_drag_recv.adapter = MarquteeRecvAdapter(mutableListOf("123", "456", "789", "666", "123", "456"))
        vp_fake_drag_recv.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE && index == 1) {
                    vp_recv_event.scrollToPosition(0)
                }
            }
        })
    }
}