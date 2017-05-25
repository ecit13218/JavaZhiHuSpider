package com.zhengyao.entity;

public class ZhiHuUser
{
	private String name;
	private String userUrl;
	private int sex;
	private String signature;
	private String profiles;
	private String location;
	private String bussiness;
	private String employment;
	private String postion;
	private String education;
	private String educationExtra;
	private int suppose;
	private int thanks;
	private int question;
	private int answer;
	private int article;
	private int followers;
	private int following;
	private int bewatched;
	private int publicEdit;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}



	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getProfiles() {
		return profiles;
	}

	public void setProfiles(String profiles) {
		this.profiles = profiles;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBussiness() {
		return bussiness;
	}

	public void setBussiness(String bussiness) {
		this.bussiness = bussiness;
	}

	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
	}

	public String getPostion() {
		return postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}


	public int getSuppose() {
		return suppose;
	}

	public void setSuppose(int suppose) {
		this.suppose = suppose;
	}

	public int getThanks() {
		return thanks;
	}

	public void setThanks(int thanks) {
		this.thanks = thanks;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public int getArticle() {
		return article;
	}

	public void setArticle(int article) {
		this.article = article;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public int getBewatched() {
		return bewatched;
	}

	public void setBewatched(int bewatched) {
		this.bewatched = bewatched;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getPublicEdit() {
		return publicEdit;
	}

	public void setPublicEdit(int publicEdit) {
		this.publicEdit = publicEdit;
	}

    public String getEducationExtra() {
        return educationExtra;
    }

    public void setEducationExtra(String educationExtra) {
        this.educationExtra = educationExtra;
    }

    @Override
    public String toString() {
        return "ZhiHuUser{" +
                "name='" + name + '\'' +
                ", userUrl='" + userUrl + '\'' +
                ", sex=" + sex +
                ", signature='" + signature + '\'' +
                ", profiles='" + profiles + '\'' +
                ", location='" + location + '\'' +
                ", bussiness='" + bussiness + '\'' +
                ", employment='" + employment + '\'' +
                ", postion='" + postion + '\'' +
                ", education='" + education + '\'' +
                ", educationExtra='" + educationExtra + '\'' +
                ", suppose=" + suppose +
                ", thanks=" + thanks +
                ", question=" + question +
                ", answer=" + answer +
                ", article=" + article +
                ", followers=" + followers +
                ", following=" + following +
                ", bewatched=" + bewatched +
                ", publicEdit=" + publicEdit +
                '}';
    }
}
