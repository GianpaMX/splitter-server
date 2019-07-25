package io.github.gianpamx.splitter.server.core

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.github.gianpamx.splitter.server.core.entity.Group
import io.github.gianpamx.splitter.server.core.gateway.Persistence
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AddGroupTest {
    @Mock
    lateinit var generateId: GenerateId

    @Mock
    lateinit var persistence: Persistence

    private lateinit var addGroup: AddGroup

    @Before
    fun setUp() {
        addGroup = AddGroup(generateId, persistence)
    }

    @Test
    fun `Add Group`() {
        val testObserver = TestObserver<Group>()
        whenever(generateId.invoke()).thenReturn(Single.just("any id"))
        whenever(persistence.createGroup(any())).thenReturn(Single.just(Group("any id", "any owner")))

        addGroup("any owner").subscribe(testObserver)

        testObserver.assertValue(Group("any id", "any owner"))
    }
}
