package com.yanxi.anim.sys.pojo;

public class AnimRole {
    private String roleId;

    private String roleName;

    private String roleCreatetime;

    private String roleUpdatetime;

    private String roleDesc;

    private String roleDuty;

    private Boolean isdeleted;

    private String deptId;
    
    private AnimDept animDept;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleCreatetime() {
        return roleCreatetime;
    }

    public void setRoleCreatetime(String roleCreatetime) {
        this.roleCreatetime = roleCreatetime == null ? null : roleCreatetime.trim();
    }

    public String getRoleUpdatetime() {
        return roleUpdatetime;
    }

    public void setRoleUpdatetime(String roleUpdatetime) {
        this.roleUpdatetime = roleUpdatetime == null ? null : roleUpdatetime.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public String getRoleDuty() {
        return roleDuty;
    }

    public void setRoleDuty(String roleDuty) {
        this.roleDuty = roleDuty == null ? null : roleDuty.trim();
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

	public AnimDept getAnimDept() {
		return animDept;
	}

	public void setAnimDept(AnimDept animDept) {
		this.animDept = animDept;
	}

	@Override
	public String toString() {
		return "AnimRole [roleId=" + roleId + ", roleName=" + roleName + ", roleCreatetime=" + roleCreatetime
				+ ", roleUpdatetime=" + roleUpdatetime + ", roleDesc=" + roleDesc + ", roleDuty=" + roleDuty
				+ ", isdeleted=" + isdeleted + ", deptId=" + deptId + ", animDept=" + animDept + "]";
	}
    
}