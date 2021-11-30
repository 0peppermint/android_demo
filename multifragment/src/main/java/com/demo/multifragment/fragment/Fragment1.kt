package com.demo.multifragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.demo.core.service.ServiceDiscoveryCenter
import com.demo.core.service.api.IMyTestService
import com.demo.core.service.impl.MyTestServiceImpl
import com.demo.multifragment.R
import kotlinx.android.synthetic.main.fragment_multi_fragment.*

class Fragment1: Fragment() {

    private var rootView: View? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_multi_fragment, container, false)
        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            arguments?.let {
                if (!isAdded && fragmentManager?.findFragmentByTag("0") == null) {
                    fragmentManager?.beginTransaction()?.add(this, "0")
                }
            }
        }
        // 把实现类注入进去
        ServiceDiscoveryCenter.register(IMyTestService::class.java, MyTestServiceImpl())
    }

    override fun onResume() {
        super.onResume()
        tv_test.text = System.currentTimeMillis().toString()

        // 读实现类
        ServiceDiscoveryCenter.proceed<IMyTestService>(IMyTestService::class.java)?.proceed()
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentManager?.beginTransaction()?.remove(this)?.commitAllowingStateLoss()
    }
}