package io.github.gianpamx.splitter.server.groups

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.github.gianpamx.splitter.server.core.AddGroup
import io.github.gianpamx.splitter.server.core.entity.Group
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GroupsPresenterTest {
    @Mock
    lateinit var addGroup: AddGroup

    private lateinit var groupsPresenter: GroupsPresenter

    @Before
    fun setUp() {
        groupsPresenter = GroupsPresenter(addGroup)
    }

    @Test
    fun `Add Group Request`() {
        val testObserver = TestObserver<Map<String, String>>()
        whenever(addGroup.invoke(any())).thenReturn(Single.just(Group("expected id", "any owner")))

        groupsPresenter.addGroupRequest(GroupInput("any owner")).subscribe(testObserver)

        testObserver.assertValueAt(0, mapOf("id" to "expected id"))
    }
}
