package com.yanxi.anim.sys.pojo;

import java.util.List;

public class AnimDept {
    private String deptId;

    private String deptName;

    private String deptDesc;

    private String deptCreatetime;

    private String deptUpdatetime;

    private Boolean isdeleted;

    private String parentId;
    
    private AnimDept parent;
    
    private List<AnimDept> children;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc == null ? null : deptDesc.trim();
    }

    public String getDeptCreatetime() {
        return deptCreatetime;
    }

    public void setDeptCreatetime(String deptCreatetime) {
        this.deptCreatetime = deptCreatetime == null ? null : deptCreatetime.trim();
    }

    public String getDeptUpdatetime() {
        return deptUpdatetime;
    }

    public void setDeptUpdatetime(String deptUpdatetime) {
        this.deptUpdatetime = deptUpdatetime == null ? null : deptUpdatetime.trim();
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

	public AnimDept getParent() {
		return parent;
	}

	public void setParent(AnimDept parent) {
		this.parent = parent;
	}

	public List<AnimDept> getChildren() {
		return children;
	}

	public void setChildren(List<AnimDept> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "AnimDept [deptId=" + deptId + ", deptName=" + deptName + ", deptDesc=" + deptDesc + ", deptCreatetime="
				+ deptCreatetime + ", deptUpdatetime=" + deptUpdatetime + ", isdeleted=" + isdeleted + ", parentId="
				+ parentId + ", parent=" + parent + ", children=" + children + "]";
	}
    
}