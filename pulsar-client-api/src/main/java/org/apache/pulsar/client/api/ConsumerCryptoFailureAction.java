/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.pulsar.client.api;

public enum ConsumerCryptoFailureAction {
    FAIL, // This is the default option to fail consume until crypto succeeds
    DISCARD, // Message is silently acknowledged and not delivered to the application
    /**
     *
     * <pre>
     * Deliver the encrypted message to the application. It's the application's responsibility to decrypt the message.
     * If message is also compressed, decompression will fail. If message contain batch messages, client will not be
     * able to retrieve individual messages in the batch.
     * </pre>
     *
     * Delivered encrypted message contains {@link EncryptionContext} which contains encryption and compression
     * information in it using which application can decrypt consumed message payload.
     *
     */
    CONSUME;
}
