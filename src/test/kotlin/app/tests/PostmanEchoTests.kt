package app.tests

import app.Integration
import app.QuickRun
import app.functions.CarServiceFunctions.isCarReady
import app.functions.CarServiceFunctions.getCars
import app.functions.CarServiceFunctions.putCar
import app.functions.EchoObject
import app.functions.PostmanEchoServiceFunctions.postWithEcho
import io.kotlintest.matchers.gt
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.specs.StringSpec

class PostmanEchoTests : StringSpec() {

    init {

        "post shoud echo" {
            postWithEcho() shouldBe EchoObject("111", "aaa")
        }.config(tags = setOf(QuickRun))

    }


}
