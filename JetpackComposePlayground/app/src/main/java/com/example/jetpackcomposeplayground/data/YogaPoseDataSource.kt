package com.example.jetpackcomposeplayground.data

import com.example.jetpackcomposeplayground.R
import com.example.jetpackcomposeplayground.model.YogaPose

object YogaPoseDataSource {
    val yogaPoses = listOf(
        YogaPose(
            nameRes = R.string.pose1,
            instructionRes = R.string.yoga_down_dog_instructions,
            imageRes = R.drawable.yoga_down_dog
        ),
        YogaPose(
            nameRes = R.string.pose2,
            instructionRes = R.string.yoga_tree_instructions,
            imageRes = R.drawable.yoga_tree
        ),
        YogaPose(
            nameRes = R.string.pose3,
            instructionRes = R.string.yoga_warrior_2_instructions,
            imageRes = R.drawable.yoga_warrior_2
        ),
        YogaPose(
            nameRes = R.string.pose4,
            instructionRes = R.string.yoga_chair_instructions,
            imageRes = R.drawable.yoga_chair_pose
        ),
        YogaPose(
            nameRes = R.string.pose5,
            instructionRes = R.string.yoga_camel_instructions,
            imageRes = R.drawable.yoga_camel_pose
        ),
        YogaPose(
            nameRes = R.string.pose6,
            instructionRes = R.string.yoga_wheel_instructions,
            imageRes = R.drawable.yoga_wheel_pose
        )
    )
}