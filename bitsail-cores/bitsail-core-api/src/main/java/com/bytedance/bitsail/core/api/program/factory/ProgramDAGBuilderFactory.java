/*
 * Copyright 2022-2023 Bytedance Ltd. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytedance.bitsail.core.api.program.factory;

import com.bytedance.bitsail.base.connector.reader.DataReaderDAGBuilder;
import com.bytedance.bitsail.base.connector.transformer.DataTransformDAGBuilder;
import com.bytedance.bitsail.base.connector.writer.DataWriterDAGBuilder;
import com.bytedance.bitsail.base.execution.Mode;
import com.bytedance.bitsail.base.packages.PluginFinder;
import com.bytedance.bitsail.common.configuration.BitSailConfiguration;

import java.io.Serializable;
import java.util.List;

public interface ProgramDAGBuilderFactory extends Serializable {

  /**
   * Get data reader builders from configuration.
   */
  List<DataReaderDAGBuilder> getDataReaderDAGBuilders(Mode mode,
                                                      List<BitSailConfiguration> readerConfigurations,
                                                      PluginFinder pluginFinder);

  /**
   * Get data writer builders from configuration.
   */
  List<DataWriterDAGBuilder> getDataWriterDAGBuilders(Mode mode,
                                                      List<BitSailConfiguration> writerConfigurations,
                                                      PluginFinder pluginFinder);

  /**
   * Get data transform builders from configuration.
   */
  default List<DataTransformDAGBuilder> getDataTransformDAGBuilders(Mode mode,
                                                                    List<BitSailConfiguration> writerConfigurations,
                                                                    PluginFinder pluginFinder) {
    throw new UnsupportedOperationException();
  }
}