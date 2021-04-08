package com.example.demo.api

import feign.Response
import feign.codec.Decoder
import java.lang.reflect.Type

class MyDecoderWrapper: Decoder {
    override fun decode(response: Response?, type: Type?): Any {
        TODO("Not yet implemented")
    }
}