package com.lingona.es4j.sample.etishor.appservice;

// Copied from NanoMessageBus (Temporary)

// Provides the ability to understand and handle a logical message.
// <typeparam name="T">The type of message to be handled.</typeparam>
// Instances of this class may be either single or multi-threaded depending upon their registration.
public interface IHandleMessages<T> {

    // Handles the message provided.
    // <param name="message">The message to be handled.</param>
    void handle(T message);
}
