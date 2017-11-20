package com.vaadin.flow.demo.helloworld;

import com.vaadin.flow.model.TemplateModel;
import com.vaadin.ui.Tag;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.polymertemplate.PolymerTemplate;

@Tag("designer-test-template")
@HtmlImport("frontend://designer-test-template.html")
public class DesignerTestTemplate extends PolymerTemplate<DesignerTestTemplate.DesignerTestTemplateModel> {

    public interface DesignerTestTemplateModel extends TemplateModel {

    }
}
