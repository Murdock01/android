/*
 * Copyright 2000-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jetbrains.jps.android.model.impl;

import com.android.SdkConstants;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.intellij.util.xmlb.annotations.AbstractCollection;
import com.intellij.util.xmlb.annotations.Attribute;
import com.intellij.util.xmlb.annotations.Tag;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import static com.android.builder.model.AndroidProject.PROJECT_TYPE_APP;
import static org.jetbrains.android.util.AndroidCommonUtils.*;

/**
 * @author nik
 */
public class JpsAndroidModuleProperties {
  public String SELECTED_BUILD_VARIANT = "";

  public String ASSEMBLE_TASK_NAME = "";
  public String COMPILE_JAVA_TASK_NAME = "";

  public String ASSEMBLE_TEST_TASK_NAME = "";
  public String COMPILE_JAVA_TEST_TASK_NAME = "";

  @Tag("afterSyncTasks")
  @AbstractCollection(surroundWithTag = false, elementTag = "task", elementValueAttribute = "")
  public Set<String> AFTER_SYNC_TASK_NAMES = Sets.newHashSet();

  // This value is false when the Android project is Gradle-based.
  public boolean ALLOW_USER_CONFIGURATION = true;

  public String GEN_FOLDER_RELATIVE_PATH_APT = "/" + SdkConstants.FD_GEN_SOURCES;
  public String GEN_FOLDER_RELATIVE_PATH_AIDL = "/" + SdkConstants.FD_GEN_SOURCES;

  public String MANIFEST_FILE_RELATIVE_PATH = "/" + SdkConstants.FN_ANDROID_MANIFEST_XML;

  public String RES_FOLDER_RELATIVE_PATH = "/" + SdkConstants.FD_RES;
  public String RES_FOLDERS_RELATIVE_PATH;
  public String ASSETS_FOLDER_RELATIVE_PATH = "/" + SdkConstants.FD_ASSETS;
  public String LIBS_FOLDER_RELATIVE_PATH = "/" + SdkConstants.FD_NATIVE_LIBS;

  public boolean USE_CUSTOM_APK_RESOURCE_FOLDER = false;
  public String CUSTOM_APK_RESOURCE_FOLDER = "";

  public boolean USE_CUSTOM_COMPILER_MANIFEST = false;
  public String CUSTOM_COMPILER_MANIFEST = "";

  public String APK_PATH = "";

  public int PROJECT_TYPE = PROJECT_TYPE_APP;

  public boolean RUN_PROCESS_RESOURCES_MAVEN_TASK = true;

  public String CUSTOM_DEBUG_KEYSTORE_PATH = "";

  public boolean PACK_TEST_CODE = false;

  public boolean RUN_PROGUARD = false;

  public String PROGUARD_LOGS_FOLDER_RELATIVE_PATH = "/" + DIRECTORY_FOR_LOGS_NAME;

  @Tag("proGuardCfgFiles")
  @AbstractCollection(surroundWithTag = false, elementTag = "file", elementValueAttribute = "")
  public List<String> myProGuardCfgFiles = Lists.newArrayList(PROGUARD_SYSTEM_CFG_FILE_URL);

  public boolean USE_CUSTOM_MANIFEST_PACKAGE = false;
  public String CUSTOM_MANIFEST_PACKAGE = "";

  public String ADDITIONAL_PACKAGING_COMMAND_LINE_PARAMETERS = "";

  public String UPDATE_PROPERTY_FILES = "";

  public boolean ENABLE_MANIFEST_MERGING = false;

  public boolean ENABLE_PRE_DEXING = true;

  public boolean COMPILE_CUSTOM_GENERATED_SOURCES = true;

  public boolean ENABLE_SOURCES_AUTOGENERATION = true;

  public boolean ENABLE_MULTI_DEX = false;
  public String MAIN_DEX_LIST = "";
  public boolean MINIMAL_MAIN_DEX = false;

  @Tag(INCLUDE_ASSETS_FROM_LIBRARIES_ELEMENT_NAME)
  public boolean myIncludeAssetsFromLibraries = false;

  @Tag("resOverlayFolders")
  @AbstractCollection(surroundWithTag = false, elementTag = "path", elementValueAttribute = "")
  public List<String> RES_OVERLAY_FOLDERS = new ArrayList<>();

  @Tag(ADDITIONAL_NATIVE_LIBS_ELEMENT)
  @AbstractCollection(surroundWithTag = false)
  public List<AndroidNativeLibDataEntry> myNativeLibs = new ArrayList<>();

  @Tag("notImportedProperties")
  @AbstractCollection(surroundWithTag = false, elementTag = "property", elementValueAttribute = "")
  public Set<AndroidImportableProperty> myNotImportedProperties = EnumSet.noneOf(AndroidImportableProperty.class);

  @Tag(ITEM_ELEMENT)
  public static class AndroidNativeLibDataEntry {
    @Attribute(ARCHITECTURE_ATTRIBUTE)
    public String myArchitecture;

    @Attribute(URL_ATTRIBUTE)
    public String myUrl;

    @Attribute(TARGET_FILE_NAME_ATTRIBUTE)
    public String myTargetFileName;
  }
}
