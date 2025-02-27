/*
 *  Copyright (c) 2020 - 2021 Microsoft Corporation
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Microsoft Corporation - initial API and implementation
 *
 */

package org.eclipse.edc.connector.transfer.spi;

import org.eclipse.edc.connector.transfer.spi.types.TransferProcess;
import org.eclipse.edc.connector.transfer.spi.types.TransferRequest;
import org.eclipse.edc.connector.transfer.spi.types.command.TransferProcessCommand;
import org.eclipse.edc.runtime.metamodel.annotation.ExtensionPoint;
import org.eclipse.edc.spi.response.StatusResult;
import org.eclipse.edc.spi.result.Result;

/**
 * Manages data transfer processes. Currently synchronous and asynchronous data transfers are supported.
 */
@ExtensionPoint
public interface TransferProcessManager {

    /**
     * Initiates a data transfer process on the consumer.
     */
    StatusResult<TransferProcess> initiateConsumerRequest(TransferRequest transferRequest);

    /**
     * Adds a single Command to the queue which is processed sequentially.
     */
    void enqueueCommand(TransferProcessCommand command);

    /**
     * Run a command syncronously
     */
    Result<Void> runCommand(TransferProcessCommand command);

}
