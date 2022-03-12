package ru.netology.hw2_2

import org.junit.Test


import org.junit.Assert.*

class WallServiceTest {

    private val testGeo = Geo (
        type = "",
        coordinates = "",
        place = null
            )
    private val testPostSource = PostSource(
        type = PostSource.PostSource_type.VK,
        platform = PostSource.PostSource_platform.ANDROID,
        data = PostSource.PostSource_data.POLL,
        url = ""
    )
    private val testComments = Comments (
        count = 0,
        canPost = false,
        groupsCanPost = false,
        canClose = false,
        canOpen = false
            )
    private val testCopyright = Copyright (
        id = 0,
        link = "",
        name = "",
        type = ""
            )
    private val testLikes = Likes (
        count = 0,
        userLikes = false,
        canLike = false,
        can_publish = false
            )
    private val testReposts = Reposts (
        count = 0,
        userReposted = false
            )
    private val testViews = Views (
        count = 0
            )
    private val testPlaceholder = 0
    private val testDonut = Donut(
        false,
        0,
        testPlaceholder,
        false,
        Donut.Donut_editMode.ALL
            )
    private val testPost = Post(
        id = 0,
        ownerId = 0,
        fromId = 0,
        createdBy = 0,
        date = 0,
        text = "",
        reply_owner_id = 0,
        replyPostId = 0,
        friendsOnly = true,
        comments = testComments,
        copyright = testCopyright,
        likes = testLikes,
        reposts = testReposts,
        views = testViews,
        postType = Post.PostType.POST,
        postSource = testPostSource,
        geo = testGeo,
        signerId = 0,
        copyHistory = null,
        canPin = false,
        canDelete = false,
        canEdit = false,
        isPinned = false,
        markedAsAds = false,
        isFavorite = false,
        donut = testDonut,
        postponedId = 0
    )


    @Test
    fun add() {
        val testPost = testPost

        val addTestResult = WallService.add(testPost)

        assertNotEquals(0, addTestResult.id)
    }

    @Test
    fun updateTrue() {
        val testPost = WallService.add(testPost)

        val updateTrueTestResult = WallService.update(testPost)

        assertTrue(updateTrueTestResult)
    }

    @Test
    fun updateFalse() {
        val testPost = WallService.add(testPost)

        val updateFalseTestResult =
            WallService.update(testPost.copy(id = 0))

        assertFalse(updateFalseTestResult)
    }
}