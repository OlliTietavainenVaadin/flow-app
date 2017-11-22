/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.demo.helloworld;

import com.vaadin.router.Route;
import com.vaadin.ui.Page;
import com.vaadin.ui.UI;
import com.vaadin.ui.button.Button;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.layout.HorizontalLayout;
import com.vaadin.ui.layout.VerticalLayout;
import com.vaadin.util.CurrentInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * The main view contains a button and a template element.
 */
@HtmlImport("styles.html")
@Route("")
public class MainView extends VerticalLayout {

    List<CharacterCard> characters = new ArrayList<>();

    HorizontalLayout charLayout = new HorizontalLayout();

    public MainView() {
        Button button = new Button("Add random", event -> addCharacter());
        add(button, charLayout);
    }

    public void addCharacter() {
        if (characters.size() >= 4) {
            UI.getCurrent().getPage().executeJavaScript("alert('foo');");
            return;

        }
        CharacterCard random = CharacterCard.createRandom();
        characters.add(random);
        charLayout.add(random);
    }

}
