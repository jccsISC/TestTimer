package com.jccsisc.mytimertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.jccsisc.mytimertest.databinding.ActivityMainBinding
import com.jccsisc.mytimertest.databinding.ActivityMainBindingImpl

class MainActivity : AppCompatActivity() {
    
    lateinit var mBinding: ActivityMainBinding
    val viewModel by viewModels<MainViewModel>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.apply {

            mainVM = viewModel

            viewModel.result.observe(this@MainActivity, {
                if (it != "00.00") {
                    tvResult.text = it
                    btnStart.isEnabled = false
                }else {
                    btnStart.isEnabled = true
                    tvResult.text = "00.00"
                    tieMinutes.setText("0")
                    tieSeconds.setText("0")
                }
            })
        }
    }
}