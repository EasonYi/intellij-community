/*
 * Copyright 2006 Sascha Weinreuter
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
package test;

public class ParseTest extends BaseParseTestcase {

    public void test0() throws Throwable {
        myFixture.testHighlighting("test0.regexp");
    }
    public void test1() throws Throwable {
        myFixture.testHighlighting("test1.regexp");
    }
    public void test2() throws Throwable {
        myFixture.testHighlighting("test2.regexp");
    }
    public void test3() throws Throwable {
        myFixture.testHighlighting("test3.regexp");
    }
    public void test4() throws Throwable {
        myFixture.testHighlighting("test4.regexp");
    }
}
