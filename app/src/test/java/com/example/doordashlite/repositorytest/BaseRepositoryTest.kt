package com.example.doordashlite.repositorytest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import org.junit.Rule
import org.junit.rules.TestRule
import org.mockito.MockitoAnnotations


abstract class BaseRepositoryTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    open fun steup(){
        MockitoAnnotations.initMocks(this)
    }

}