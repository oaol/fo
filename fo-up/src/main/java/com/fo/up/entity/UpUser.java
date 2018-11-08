package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UpUser {
    @Id
    @GeneratedValue
    private Long userId;// 编号
    @Column(nullable = false)
    private String username;// 帐号
    @Column(nullable = false)
    private String password;// 密码MD5(密码+盐)
    @Column(nullable = false)
    private String salt;// 盐'
    @Column(nullable = true)
    private String realname;// '姓名'
    @Column(nullable = true)
    private String avatar;// 头像
    @Column(nullable = true)
    private String phone;// 电话
    @Column(nullable = true)
    private String email;// 邮箱
    @Column(nullable = true)
    private int sex;// 性别
    @Column(nullable = true)
    private int locked;// ״(状态(0:正常,1:锁定)
    @Column(nullable = true)
    private long ctime;// 创建时间

   
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public long getCtime() {
		return ctime;
	}

	public void setCtime(long ctime) {
		this.ctime = ctime;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

  

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

}
