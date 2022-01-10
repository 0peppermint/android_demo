package com.demo.multifragment.someuifragment.marqutee

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class MarquteeTransformer: ViewPager2.PageTransformer {
    private val MIN_SCALE = 1f
    override fun transformPage(page: View, position: Float) {
        if(position < -1){
            page.setScaleY(MIN_SCALE);
        }else if(position<= 1){
            //
            val scale = Math.max(MIN_SCALE,1 - Math.abs(position));
            page.setScaleY(scale);
            /*page.setScaleX(scale);

            if(position<0){
                page.setTranslationX(width * (1 - scale) /2);
            }else{
                page.setTranslationX(-width * (1 - scale) /2);
            }*/

        }else{
            page.setScaleY(MIN_SCALE);
        }
    }

}