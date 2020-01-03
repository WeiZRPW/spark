/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.catalyst.analysis

import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.plans.logical.LeafNode
import org.apache.spark.sql.connector.catalog.{Identifier, Table, TableCatalog}

case class ResolvedTable(catalog: TableCatalog, identifier: Identifier, table: Table)
  extends LeafNode {
  override def output: Seq[Attribute] = Nil
}

case class UnresolvedTable(multipartIdentifier: Seq[String]) extends LeafNode {
  override lazy val resolved: Boolean = false

  override def output: Seq[Attribute] = Nil
}