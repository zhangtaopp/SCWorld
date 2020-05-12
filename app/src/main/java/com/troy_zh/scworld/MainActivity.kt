package com.troy_zh.scworld

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TableLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.tabs.TabLayout
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var flContainer: FrameLayout
    val tabsList= listOf<String>("诗词","我的")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tabLayout)
        flContainer = findViewById(R.id.fl_container)
        val poetryFragment = ARouter.getInstance().build("/poetry/home").navigation() as Fragment
        val mineFragment = ARouter.getInstance().build("/mine/home").navigation() as Fragment

        val fragmentList = listOf<Fragment>(poetryFragment, mineFragment)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_container, fragmentList[0]).commit()
        for (tab in tabsList){
            tabLayout.addTab(tabLayout.newTab().setText(tab))
        }
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                val index = tabsList.indexOf(p0?.text.toString())
                Toast.makeText(this@MainActivity,""+ index,Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction().replace(R.id.fl_container, fragmentList[index]).commit()
            }

        })
    }
}
