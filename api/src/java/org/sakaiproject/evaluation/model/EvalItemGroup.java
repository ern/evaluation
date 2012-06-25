/**
 * Copyright 2005 Sakai Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.sakaiproject.evaluation.model;

// Generated Mar 20, 2007 10:08:13 AM by Hibernate Tools 3.2.0.beta6a

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * EvalItemGroup generated by hbm2java
 */
public class EvalItemGroup implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    // Fields

    private Long id;

    private Date lastModified;

    private String owner;

    private String type;

    private String title;

    private String description;

    private Boolean expert;

    private EvalItemGroup parent;

    private Set<EvalItem> groupItems = new HashSet<EvalItem>(0);

    // Constructors

    /** default constructor */
    public EvalItemGroup() {
    }

    /** minimal constructor */
    public EvalItemGroup(String owner, String type, String title) {
        this(owner, type, title, null, Boolean.FALSE, null, null);
    }

    /** full constructor */
    public EvalItemGroup(String owner, String type, String title, String description, Boolean expert,
            EvalItemGroup parent, Set<EvalItem> groupItems) {
        this.lastModified = new Date();
        this.owner = owner;
        this.type = type;
        this.title = title;
        this.description = description;
        this.expert = expert;
        this.parent = parent;
        if (groupItems != null) {
            this.groupItems = groupItems;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getExpert() {
        return expert;
    }

    public void setExpert(Boolean expert) {
        this.expert = expert;
    }

    public Set<EvalItem> getGroupItems() {
        return groupItems;
    }

    public void setGroupItems(Set<EvalItem> groupItems) {
        this.groupItems = groupItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public EvalItemGroup getParent() {
        return parent;
    }

    public void setParent(EvalItemGroup parent) {
        this.parent = parent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
