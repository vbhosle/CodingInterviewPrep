package practice.geeksforgeeks;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import practice.geeksforgeeks.GroupsInFriends.Friend;

public class GroupsInFriendsTest {

	@Test
	public void test01() {
		Friend friend_1 = new Friend(1);
		Friend friend_2 = new Friend(2);
		friend_1.addFriend(friend_2);
		friend_2.addFriend(friend_1);

		Friend friend_3 = new Friend(3);
		Friend friend_4 = new Friend(4);
		friend_3.addFriend(friend_4);
		friend_4.addFriend(friend_3);

		Friend friend_5 = new Friend(5);
		Friend friend_6 = new Friend(6);
		friend_5.addFriend(friend_6);
		friend_6.addFriend(friend_5);

		List<Friend> friends = Arrays.asList(friend_1, friend_2, friend_3, friend_4, friend_5, friend_6);
		List<Integer> groups = GroupsInFriends.getNumberOfGroups(friends);

		assertThat("Current groups don't match", groups.size(), equalTo(3));
		assertThat("New groups don't match", groups.stream().reduce(1, (x, y) -> x * y), equalTo(8));
	}

	@Test
	public void test02() {
		Friend friend_1 = new Friend(1);
		Friend friend_2 = new Friend(2);
		friend_1.addFriend(friend_2);
		friend_2.addFriend(friend_1);

		Friend friend_3 = new Friend(3);
		friend_2.addFriend(friend_3);
		friend_3.addFriend(friend_3);

		Friend friend_4 = new Friend(4);

		List<Friend> friends = Arrays.asList(friend_1, friend_2, friend_3, friend_4);
		List<Integer> groups = GroupsInFriends.getNumberOfGroups(friends);

		assertThat("Current groups don't match", groups.size(), equalTo(2));
		assertThat("New groups don't match", groups.stream().reduce(1, (x, y) -> x * y), equalTo(3));
	}

}
