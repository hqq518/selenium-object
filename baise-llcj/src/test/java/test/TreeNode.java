package test;

import java.util.List;

/**
 * 树节点对象
 */
public class TreeNode {

    private String title;   // 节点标题
    private String id;      // 节点id
    private String field;   // 节点字段名,一般对应表字段名
    private String href;    // 点击节点弹出新窗口对应的 url
    private Boolean spread = false;     // 节点是否初始展开
    private Boolean checked = false;    // 节点是否初始为选中状态（如果开启复选框的话）
    private Boolean disabled = false;   // 节点是否为禁用状态
    private List<TreeNode> children;    // 子节点

    public TreeNode(){}

    public TreeNode(String title, String id, boolean spread){
        this.title = title;
        this.id = id;
        this.spread = spread;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }


}
