package com.whoEatsWhere.daos

import com.whoEatsWhere.Entities.User
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by idank on 31/07/2014.
 */
class UserDaoImplTest extends FlatSpec with Matchers{

  "A UserDaoImpl" should "get user after insert" in {
    val userDao = new UserDaoImpl
    val newUser = new User()
    newUser.setEmail("test@test.co")
    userDao.save(newUser )
    userDao.get() should be (2)
    stack.pop() should be (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }
}
