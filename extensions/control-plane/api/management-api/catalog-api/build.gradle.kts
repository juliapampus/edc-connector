/*
 *  Copyright (c) 2020 - 2022 Bayerische Motoren Werke Aktiengesellschaft (BMW AG)
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
plugins {
    `java-library`
    id("io.swagger.core.v3.swagger-gradle-plugin")
}

dependencies {
    api(project(":spi:control-plane:control-plane-spi"))
    implementation(project(":extensions:common:api:api-core"))
    implementation(project(":extensions:common:api:management-api-configuration"))
    implementation(project(":core:common:validator-core"))

    implementation(libs.jakarta.rsApi)

    testImplementation(project(":extensions:common:http"))
    testImplementation(project(":extensions:common:iam:iam-mock"))

    testImplementation(project(":core:common:junit"))
    testImplementation(project(":core:control-plane:control-plane-core"))
    testImplementation(project(":core:data-plane-selector:data-plane-selector-core"))
    testImplementation(testFixtures(project(":extensions:common:http:jersey-core")))
    testImplementation(libs.restAssured)
}

edcBuild {
    swagger {
        apiGroup.set("management-api")
    }
}


