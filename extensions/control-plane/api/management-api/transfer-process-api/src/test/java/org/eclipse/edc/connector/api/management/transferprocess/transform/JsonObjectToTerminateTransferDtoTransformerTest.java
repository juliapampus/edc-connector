/*
 *  Copyright (c) 2023 Bayerische Motoren Werke Aktiengesellschaft (BMW AG)
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Bayerische Motoren Werke Aktiengesellschaft (BMW AG) - initial API and implementation
 *
 */

package org.eclipse.edc.connector.api.management.transferprocess.transform;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import org.eclipse.edc.connector.api.management.transferprocess.model.TerminateTransferDto;
import org.eclipse.edc.transform.spi.TransformerContext;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.eclipse.edc.connector.api.management.transferprocess.model.TerminateTransferDto.EDC_TERMINATE_TRANSFER_REASON;
import static org.eclipse.edc.connector.api.management.transferprocess.model.TerminateTransferDto.EDC_TERMINATE_TRANSFER_TYPE;
import static org.eclipse.edc.jsonld.spi.JsonLdKeywords.TYPE;
import static org.mockito.Mockito.mock;

class JsonObjectToTerminateTransferDtoTransformerTest {

    private final JsonObjectToTerminateTransferDtoTransformer transformer = new JsonObjectToTerminateTransferDtoTransformer();
    private final TransformerContext context = mock(TransformerContext.class);

    @Test
    void types() {
        assertThat(transformer.getInputType()).isEqualTo(JsonObject.class);
        assertThat(transformer.getOutputType()).isEqualTo(TerminateTransferDto.class);
    }

    @Test
    void transform() {
        var json = Json.createObjectBuilder()
                .add(TYPE, EDC_TERMINATE_TRANSFER_TYPE)
                .add(EDC_TERMINATE_TRANSFER_REASON, "reason")
                .build();

        var result = transformer.transform(json, context);

        assertThat(result).isNotNull();
        assertThat(result.getReason()).isEqualTo("reason");
    }
}
