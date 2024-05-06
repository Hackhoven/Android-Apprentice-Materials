package com.raywenderlich.listmaker.ui.main

import androidx.lifecycle.ViewModel
import com.raywenderlich.listmaker.models.TaskList
import android.content.SharedPreferences

// 1
class MainViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {

    // 2
    lateinit var onListAdded: (() -> Unit)

    // 3
    val list: MutableList<TaskList> by lazy {
        retrieveLists()
    }

    // 4
    private fun retrieveLists(): MutableList<TaskList> {
        val sharedPreferencesContents = sharedPreferences.all
        val taskLists = ArrayList<TaskList>()
        for (taskList in sharedPreferencesContents) {
            val itemsHashSet = ArrayList(taskList.value as HashSet<String>)
            val list = TaskList(taskList.key, itemsHashSet)
            taskLists.add(list)
        }
        return taskLists
    }

    // 5
    fun saveList(newlist: TaskList) {
        sharedPreferences.edit().putStringSet(newlist.name, newlist.tasks.toHashSet()).apply()
        list.add(newlist)
        onListAdded.invoke()
    }
}
