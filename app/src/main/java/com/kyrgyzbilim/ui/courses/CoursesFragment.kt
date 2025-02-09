package com.kyrgyzbilim.ui.courses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.kyrgyzbilim.R
import com.kyrgyzbilim.base.InjectorObject
import com.kyrgyzbilim.data.Course
import com.kyrgyzbilim.ui.adapters.CoursesAdapter
import kotlinx.android.synthetic.main.fragment_courses.*


class CoursesFragment : Fragment(), CoursesAdapter.CoursesClickListener {

    private lateinit var adapter: CoursesAdapter

//    private val mainViewModel: CourseViewModel by viewModels {
//        InjectorObject.getMainViewModelFactory()
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_courses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerCourse.hasFixedSize()
        adapter = CoursesAdapter(this)

        loadData()



    }

    private fun loadData() {
//        val course = сourseViewModel.getCourse()
        val course  = Course(1,"Beginner","When an application component starts and the application does not have any other components running, the Android system", 20)
        val course1  = Course(2,"Elementary","When an application component starts and the application does not have any other components running, the Android system", 20)
        val course2  = Course(3,"Pre-intermediate","When an application component starts and the application does not have any other components running, the Android system", 20)
        val course3  = Course(4,"Intermediate","When an application component starts and the application does not have any other components running, the Android system", 20)
        val course4  = Course(5,"Upper-intermediate","When an application component starts and the application does not have any other components running, the Android system", 20)
        val course5  = Course(6,"Intermediate","When an application component starts and the application does not have any other components running, the Android system", 20)
        val course6  = Course(7,"Intermediate","When an application component starts and the application does not have any other components running, the Android system", 20)
        val courseFakeList = arrayListOf(course, course1, course2, course3, course4, course5, course6)
        recyclerCourse.adapter = adapter
        adapter.submitList(courseFakeList)
    }

    override fun onClickCourse(position: Int) {

        val current = adapter.getItemId(position)

        //TODO: open ThemesFragment
    }
}