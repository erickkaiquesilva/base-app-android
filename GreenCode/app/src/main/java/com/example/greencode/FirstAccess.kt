package com.example.greencode

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.size
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_first_access.*
import kotlinx.android.synthetic.main.activity_first_access_infos.view.*
import kotlin.math.abs

class FirstAccess : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_access)

        val views:Array<Page> = arrayOf(
            Page(
                this.getText(R.string.first_access_title_1).toString(),
                this.getText(R.string.first_access_text_1).toString(),
                R.drawable.earth_icon
            ),
            Page(
                this.getText(R.string.first_access_title_2).toString(),
                this.getText(R.string.first_access_text_2).toString(),
                R.drawable.splash_icon
            ),
            Page(
                this.getText(R.string.first_access_title_3).toString(),
                this.getText(R.string.first_access_text_3).toString(),
                R.drawable.splash_icon
            )
        )

        addDots(views.size)
        view_pager.adapter = OnboardingAdapter(views)
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                addDots(views.size, position)
                if(view_pager.currentItem == (views.size -18)){
                    btn_next.text = getString(R.string.finish)
                }
                else if(view_pager.currentItem < (views.size - 1)){
                    btn_next.text = getString(R.string.next)
                }
            }

        })

        btn_next.setOnClickListener {
            if(view_pager.currentItem == view_pager.size){
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                finish()
            }
            else if(view_pager.currentItem == (views.size - 2)){
                btn_next.text = getString(R.string.finish)
            }
            view_pager.setCurrentItem(view_pager.currentItem + 1, true)
        }
    }

    private fun addDots(size: Int, position: Int = 0) {
        dots.removeAllViews()
        Array(size){
        val textView = TextView(baseContext).apply{
            text = getText(R.string.dotted)
            textSize = 35f
            if(position == it){
                setTextColor(Color.parseColor("#26BF4C"))
            }
            else{
                setTextColor(Color.parseColor("#E8E8E8"))
            }
        }
        dots.addView(textView)
    }
    }

    private inner class OnboardingAdapter(val views: Array<Page>) : PagerAdapter() {
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view: View = layoutInflater.inflate(
                R.layout.activity_first_access_infos, container,
                false
            )

            with(views[position]) {
                view.first_access_title.text = Html.fromHtml(title)
                view.first_access_text.text = Html.fromHtml(subtitle)
                view.first_access_icon.setImageResource(icon)
            }

            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun getCount(): Int = views.size
    }
}
