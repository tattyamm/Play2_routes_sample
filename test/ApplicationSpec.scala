package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

/**
 * この辺りを参考にした
 * http://playdocja.appspot.com/documentation/2.0.2/ScalaTest
 * http://playdocja.appspot.com/documentation/2.0.2/ScalaFunctionalTest
 * https://github.com/playframework/Play20/blob/master/samples/scala/helloworld/test/ApplicationSpec.scala
 * http://how-to-use-playframework-20.readthedocs.org/en/latest/subdocs/initial_create_application.html
 */

class ApplicationSpec extends Specification {

  "indexにアクセスがあった場合" should {
    "正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/"))
      status(result) must equalTo(OK)
      contentType(result) must beSome("text/html")
      charset(result) must beSome("utf-8")
      contentAsString(result) must contain("index")
    }
  }

  "test11にアクセスがあった場合" should {
    "正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/test11"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test11")
    }
  }

  "test12にアクセスがあった場合" should {
    "正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/test12/123"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test12 ID:123")
    }
    "間違った型にはエラーを返す" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/test12/hoge"))
      status(result) must equalTo(BAD_REQUEST)
    }
    "間違ったパラメータにはエラーを返す" in {
      running(FakeApplication()) {
        routeAndCall(FakeRequest(GET, "/test12?id=123")) must equalTo(None) //TODO 正しい書き方がわからない。「間違った型にはエラーを返す」と同じように記述すれば良いのではないのか？
      }
    }
  }

  "test13にアクセスがあった場合" should {
    "文字列を渡すと正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/test13/hoge"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test13 name:hoge")
    }
    "数字を渡すと正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/test13/123"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test13 name:123")
    }
  }

  "test14にアクセスがあった場合" should {
    "正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/test14/1234"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test14 ID:1234")
    }
    "間違ったパラメータにはエラーを返す" in {
      running(FakeApplication()) {
        routeAndCall(FakeRequest(GET, "/test14/12345")) must equalTo(None) //TODO 正しい書き方がわからない。
      }
    }
  }

  "test21にアクセスがあった場合" should {
    "正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/test21"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test21")
    }
  }

  "test22にアクセスがあった場合" should {
    "正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/test22/123"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test22 ID:123")
    }
    "間違ったパラメータにはエラーを返す" in {
      running(FakeApplication()) {
        routeAndCall(FakeRequest(GET, "/test22?id=123")) must equalTo(None) //TODO 正しい書き方がわからない。
      }
    }

  }

  "test23にアクセスがあった場合" should {
    "正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/test23?id=123"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test23 ID:123")
    }
    "間違ったパラメータにはエラーを返す" in {
      running(FakeApplication()) {
        routeAndCall(FakeRequest(GET, "/test23/123")) must equalTo(None) //TODO 正しい書き方がわからない。
      }
    }
  }

  "test24にアクセスがあった場合" should {
    "正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/test24/hoge"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test24 name:hoge")
    }
  }

  "test25にアクセスがあった場合" should {
    "正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(GET, "/test25?name=hoge"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test25 name:hoge")
    }
  }

  "test31にアクセスがあった場合" should {
    "正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(POST, "/test31"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test31")
    }
    "間違ったメソッドには404を返す" in {
      running(FakeApplication()) {
        routeAndCall(FakeRequest(GET, "/test31")) must beNone
      }
    }
  }

  "test32にアクセスがあった場合" should {
    "正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(PUT, "/test32"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test32")
    }
    "間違ったメソッドには404を返す" in {
      running(FakeApplication()) {
        routeAndCall(FakeRequest(GET, "/test32")) must beNone
      }
    }
  }

  "test33にアクセスがあった場合" should {
    "正常なレスポンスを返す" in {
      val Some(result) = routeAndCall(FakeRequest(DELETE, "/test33"))
      status(result) must equalTo(OK)
      contentAsString(result) must contain("test33")
    }
    "間違ったメソッドには404を返す" in {
      running(FakeApplication()) {
        routeAndCall(FakeRequest(GET, "/test33")) must beNone
      }
    }
  }


  "定義してないURIにアクセスがあった場合" should {
    "404を返す" in {
      running(FakeApplication()) {
        routeAndCall(FakeRequest(GET, "/hoge")) must beNone
      }
    }
  }


}