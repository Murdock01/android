/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.tools.idea.gradle.dsl.model.repositories;

import com.android.tools.idea.gradle.dsl.model.values.GradleNullableValue;
import com.android.tools.idea.gradle.dsl.parser.repositories.MavenCredentialsDslElement;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MavenCredentialsModel {
  @NonNls private static final String USERNAME = "username";
  @NonNls private static final String PASSWORD = "password";

  @NotNull private final MavenCredentialsDslElement myDslElement;

  public MavenCredentialsModel(@NotNull MavenCredentialsDslElement dslElement) {
    myDslElement = dslElement;
  }

  @NotNull
  public GradleNullableValue<String> username() {
    return myDslElement.getLiteralProperty(USERNAME, String.class);
  }

  @NotNull
  public GradleNullableValue<String> password() {
    return myDslElement.getLiteralProperty(PASSWORD, String.class);
  }
}
