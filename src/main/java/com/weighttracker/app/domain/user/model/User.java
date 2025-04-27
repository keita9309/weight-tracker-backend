package com.weighttracker.app.domain.user.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {

	/** ID */
	private Long id;
	/** ユーザ名 */
	private String username;
	/** メールアドレス */
	private String email;
	/** パスワード */
	private Password password;
	/** 名前（名） */
	private String firstName;
	/** 名前（姓） */
	private String lastName;
	/** 登録日時 */
	private LocalDateTime createdAt;
	/** 更新日時 */
	private LocalDateTime updatedAt;

	// DBからロードする用コンストラクタ
	public User(Long id, String username, String email, Password password, String firstName, String lastName,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// 新規作成用ファクトリーメソッド（SignUp用）
    public static User createNewUser(String username, String email, Password password, String firstName, String lastName) {
        LocalDateTime now = LocalDateTime.now();
        return new User(null, username, email, password, firstName, lastName, now, now);
    }

}