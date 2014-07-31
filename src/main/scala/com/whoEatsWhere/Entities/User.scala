package com.whoEatsWhere.Entities

import javax.persistence.Entity

import lombok.AllArgsConstructor

import scala.beans.BeanProperty

/**
 * Created by idank on 31/07/2014.
 */
@Entity
@AllArgsConstructor
class User extends AbstractEntity{

  @BeanProperty
  var email: String = null
  @BeanProperty
  var lastName: String = null
  @BeanProperty
  var firstName: String = null

}
