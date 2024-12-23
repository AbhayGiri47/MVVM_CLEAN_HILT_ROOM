package com.example.mvvmcleanhiltroom.presentation.example.activity

import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.mvvmcleanhiltroom.base.BaseActivity
import com.example.mvvmcleanhiltroom.databinding.ActivityExampleBinding
import com.example.mvvmcleanhiltroom.presentation.example.viewmodel.ExampleViewModel
import com.example.mvvmcleanhiltroom.presentation.states.ResourceState
import com.example.mvvmcleanhiltroom.utils.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExampleActivity : BaseActivity<ActivityExampleBinding>() {

    private val exampleViewModel: ExampleViewModel by viewModels()

    override fun getViewBinding(): ActivityExampleBinding {
        return ActivityExampleBinding.inflate(layoutInflater)
    }

    override fun observeViewModel() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    exampleViewModel.indNzMatchDetails.collectLatest {
                        val response = it ?: return@collectLatest
                        when (response.status) {
                            ResourceState.LOADING -> {
                                customProgressBar.show()
                            }

                            ResourceState.SUCCESS -> {
                                binding.tvApiSuccess.show()
                                customProgressBar.hide()
                            }

                            ResourceState.ERROR -> {
                                customProgressBar.hide()
                                Toast.makeText(
                                    this@ExampleActivity,
                                    "Failed to get Data: ${it.error?.msg}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }

                launch {
                    exampleViewModel.saPakMatchDetails.collectLatest {
                        val response = it ?: return@collectLatest
                        when (response.status) {
                            ResourceState.LOADING -> {
                                customProgressBar.show()
                            }

                            ResourceState.SUCCESS -> {
                                customProgressBar.hide()
                                binding.tvApiSuccess.show()
                                exampleViewModel.getExampleToken()
                            }

                            ResourceState.ERROR -> {
                                customProgressBar.hide()
                                Toast.makeText(
                                    this@ExampleActivity,
                                    "Failed to get Data: ${it.error?.msg}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }

                launch {
                    exampleViewModel.exampleToken.collectLatest {
                        val response = it ?: return@collectLatest
                        when (response.status) {
                            ResourceState.LOADING -> {
                                customProgressBar.show()
                            }

                            ResourceState.SUCCESS -> {
                                customProgressBar.hide()
                                Toast.makeText(this@ExampleActivity, response.data.toString(), Toast.LENGTH_SHORT).show()
                            }

                            ResourceState.ERROR -> {
                                customProgressBar.hide()
                                Toast.makeText(
                                    this@ExampleActivity,
                                    "Failed to get Data: ${it.error?.msg}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun initialize() {

        exampleViewModel.getIndNzMatchDetails()
        exampleViewModel.getSaPakMatchDetails()
        exampleViewModel.setExampleToken("Initial Token")
    }
}