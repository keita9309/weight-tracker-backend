package com.weighttracker.app.domain.user.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weighttracker.app.domain.user.model.User;

@Mapper
public interface UserRepository {
	
	/** 全件取得 */
	List<User> findAll();

	/** IDを条件に特定のデータを取得 */
    User findById(@Param("id") Long id);

	/** ユーザ名を条件に特定のデータを取得 */
    User findByUsername(@Param("username") String username);

	/** メールアドレスを条件に特定のデータを取得 */
    Optional<User> findByEmail(@Param("email") String email);

	/** 登録処理 */
    void insert(User user);

	/** 更新処理 */
    void update(User user);

	/** 削除処理 */
    void delete(@Param("id") Long id);

}
