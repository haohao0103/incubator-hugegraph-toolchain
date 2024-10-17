/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.apache.hugegraph.loader.direct.loader;

import org.apache.hugegraph.serializer.direct.struct.Directions;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface DirectLoader<T, R> {
    JavaPairRDD<T, R> buildVertexAndEdge(Dataset<Row> ds, Directions directions);

    String generateFiles(JavaPairRDD<T, R> buildAndSerRdd);

    void loadFiles(String path,Directions directions);

    void bulkload(Dataset<Row> ds);
}
