/*
package furhatos.app.newskill.flow.main

import org.zeromq.ZMQ

val context: ZMQ.Context = ZMQ.context(1)

fun getConnectedSocket(socketType: Int, port: String, receiveTimeout: Int = -1): ZMQ.Socket {
    val socket = context.socket(socketType)
    if (receiveTimeout >= 0) socket.receiveTimeOut = receiveTimeout
    socket.subscribe("")
    //Möglichkeit Messages zu filtern TODO können möglicherweise auch bilder gefiltert werden?

    socket.connect(port)


    return socket


}

 */