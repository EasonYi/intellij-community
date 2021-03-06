/*
 * Copyright 2000-2013 JetBrains s.r.o.
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
package com.siyeh.ig.naming;

import com.intellij.psi.PsiIdentifier;
import com.intellij.psi.PsiTypeParameter;
import com.siyeh.InspectionGadgetsBundle;
import com.siyeh.ig.BaseInspectionVisitor;
import org.jetbrains.annotations.NotNull;

public class TypeParameterNamingConventionInspectionBase extends ConventionInspection {
  private static final int DEFAULT_MIN_LENGTH = 1;
  private static final int DEFAULT_MAX_LENGTH = 1;

  @Override
  @NotNull
  public String getDisplayName() {
    return InspectionGadgetsBundle.message(
      "type.parameter.naming.convention.display.name");
  }

  @Override
  protected boolean buildQuickFixesOnlyForOnTheFlyErrors() {
    return true;
  }

  @Override
  @NotNull
  public String buildErrorString(Object... infos) {
    final String parameterName = (String)infos[0];
    if (parameterName.length() < getMinLength()) {
      return InspectionGadgetsBundle.message(
        "type.parameter.naming.convention.problem.descriptor.short");
    }
    else if (parameterName.length() > getMaxLength()) {
      return InspectionGadgetsBundle.message(
        "type.parameter.naming.convention.problem.descriptor.long");
    }
    return InspectionGadgetsBundle.message(
      "enumerated.class.naming.convention.problem.descriptor.regex.mismatch",
      getRegex());
  }

  @Override
  protected String getDefaultRegex() {
    return "[A-Z][A-Za-z\\d]*";
  }

  @Override
  protected int getDefaultMinLength() {
    return DEFAULT_MIN_LENGTH;
  }

  @Override
  protected int getDefaultMaxLength() {
    return DEFAULT_MAX_LENGTH;
  }

  @Override
  public BaseInspectionVisitor buildVisitor() {
    return new NamingConventionsVisitor();
  }

  private class NamingConventionsVisitor extends BaseInspectionVisitor {

    @Override
    public void visitTypeParameter(PsiTypeParameter parameter) {
      super.visitTypeParameter(parameter);
      final String name = parameter.getName();
      if (name == null) {
        return;
      }
      if (isValid(name)) {
        return;
      }
      final PsiIdentifier nameIdentifier = parameter.getNameIdentifier();
      if (nameIdentifier == null) {
        return;
      }
      registerError(nameIdentifier, name);
    }
  }
}
