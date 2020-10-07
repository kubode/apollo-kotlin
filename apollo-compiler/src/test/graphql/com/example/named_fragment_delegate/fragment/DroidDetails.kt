// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.named_fragment_delegate.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/**
 * An autonomous mechanical character in the Star Wars universe
 */
@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
interface DroidDetails : GraphqlFragment {
  val __typename: String

  /**
   * What others call this droid
   */
  val name: String

  /**
   * This droid's primary function
   */
  val primaryFunction: String?

  /**
   * This droid's friends, or an empty list if they have none
   */
  val friends: List<Friend?>?

  /**
   * A character from the Star Wars universe
   */
  interface Friend {
    val __typename: String

    /**
     * The name of the character
     */
    val name: String

    fun marshaller(): ResponseFieldMarshaller
  }

  /**
   * A character from the Star Wars universe
   */
  data class Friend1(
    override val __typename: String = "Character",
    /**
     * The name of the character
     */
    override val name: String
  ) : Friend {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller.invoke { writer ->
        writer.writeString(RESPONSE_FIELDS[0], this@Friend1.__typename)
        writer.writeString(RESPONSE_FIELDS[1], this@Friend1.name)
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forString("name", "name", null, false, null)
      )

      operator fun invoke(reader: ResponseReader): Friend1 = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        Friend1(
          __typename = __typename,
          name = name
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Friend1> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * An autonomous mechanical character in the Star Wars universe
   */
  data class DefaultImpl(
    override val __typename: String = "Droid",
    /**
     * What others call this droid
     */
    override val name: String,
    /**
     * This droid's primary function
     */
    override val primaryFunction: String?,
    /**
     * This droid's friends, or an empty list if they have none
     */
    override val friends: List<Friend1?>?
  ) : DroidDetails {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller.invoke { writer ->
        writer.writeString(RESPONSE_FIELDS[0], this@DefaultImpl.__typename)
        writer.writeString(RESPONSE_FIELDS[1], this@DefaultImpl.name)
        writer.writeString(RESPONSE_FIELDS[2], this@DefaultImpl.primaryFunction)
        writer.writeList(RESPONSE_FIELDS[3], this@DefaultImpl.friends) { value, listItemWriter ->
          value?.forEach { value ->
            listItemWriter.writeObject(value?.marshaller())}
        }
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forString("name", "name", null, false, null),
        ResponseField.forString("primaryFunction", "primaryFunction", null, true, null),
        ResponseField.forList("friends", "friends", null, true, null)
      )

      operator fun invoke(reader: ResponseReader): DefaultImpl = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        val primaryFunction = readString(RESPONSE_FIELDS[2])
        val friends = readList<Friend1>(RESPONSE_FIELDS[3]) { reader ->
          reader.readObject<Friend1> { reader ->
            Friend1(reader)
          }
        }
        DefaultImpl(
          __typename = __typename,
          name = name,
          primaryFunction = primaryFunction,
          friends = friends
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<DefaultImpl> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    val FRAGMENT_DEFINITION: String = """
        |fragment DroidDetails on Droid {
        |  __typename
        |  name
        |  primaryFunction
        |  friends {
        |    __typename
        |    name
        |  }
        |}
        """.trimMargin()

    operator fun invoke(reader: ResponseReader): DroidDetails = DefaultImpl(reader)
  }
}