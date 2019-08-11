package practice.geeksforgeeks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://www.geeksforgeeks.org/number-groups-formed-graph-friends/
public class GroupsInFriends {

	public static List<Integer> getNumberOfGroups(List<Friend> friends) {
		List<Integer> groups = new ArrayList<>();
		int groupCount;

		final Queue<Friend> queue = new LinkedList<>();
		final Set<Friend> visited = new HashSet<>();

		Friend currentFriend;
		for (Friend friend : friends) {
			if (visited.contains(friend)) {
				continue;
			}

			groupCount = 0;
			queue.add(friend);
			visited.add(friend);

			while (!queue.isEmpty()) {
				currentFriend = queue.remove();

//				for (Friend nextFriend : currentFriend.friends) {
//					if (!visited.contains(nextFriend)) {
//						queue.add(nextFriend);
//						visited.add(nextFriend);
//					}
//				}

				// OR

				currentFriend.friends.stream().filter(f -> !visited.contains(f)).forEach(f -> {
					queue.add(f);
					visited.add(f);
				});
				groupCount++;
			}
			groups.add(groupCount);
		}

		return groups;
	}

	static class Friend {
		int id;
		Set<Friend> friends = new HashSet<>();

		public Friend(int id) {
			this.id = id;
		}

		public void addFriend(Friend friend) {
			this.friends.add(friend);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Friend other = (Friend) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Friend [id=" + id + "]";
		}

	}
}
