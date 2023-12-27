package design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author FLIGHT
 * <p>
 * 2254. Design Video Sharing Platform
 * Hard
 * 75
 * 10
 * company
 * Google
 * You have a video sharing platform where users can upload and delete videos.
 * Each video is a string of digits, where the ith digit of the string represents the content of the video at minute i.
 * For example, the first digit represents the content at minute 0 in the video,
 * the second digit represents the content at minute 1 in the video, and so on.
 * Viewers of videos can also like and dislike videos.
 * Internally, the platform keeps track of the number of views, likes, and dislikes on each video.
 * <p>
 * When a video is uploaded, it is associated with the smallest available integer videoId starting from 0.
 * Once a video is deleted, the videoId associated with that video can be reused for another video.
 * <p>
 * Implement the VideoSharingPlatform class:
 * <p>
 * VideoSharingPlatform() Initializes the object.
 * int upload(String video) The user uploads a video. Return the videoId associated with the video.
 * void remove(int videoId) If there is a video associated with videoId, remove the video.
 * String watch(int videoId, int startMinute, int endMinute) If there is a video associated with videoId,
 * increase the number of views on the video by 1 and return the substring of the video string starting at startMinute
 * and ending at min(endMinute, video.length - 1) (inclusive). Otherwise, return "-1".
 * void like(int videoId)
 * Increases the number of likes on the video associated with videoId by 1 if there is a video associated with videoId.
 * void dislike(int videoId)
 * Increases the number of dislikes on the video associated with videoId by 1 if there is a video associated with videoId.
 * int[] getLikesAndDislikes(int videoId)
 * Return a 0-indexed integer array values of length 2 where values[0] is the number of likes and values[1]
 * is the number of dislikes on the video associated with videoId. If there is no video associated with videoId, return [-1].
 * int getViews(int videoId) Return the number of views on the video associated with videoId,
 * if there is no video associated with videoId, return -1.
 */
public class VideoSharingPlatform {

  private final Map<Integer, String> videos;
  private final Map<Integer, Integer> views;
  private final Map<Integer, Integer> likes;
  private final Map<Integer, Integer> dislikes;
  private final PriorityQueue<Integer> queue;
  private final AtomicInteger maxGeneratedId;

  public VideoSharingPlatform() {
    this.videos = new HashMap<>();
    this.views = new HashMap<>();
    this.likes = new HashMap<>();
    this.dislikes = new HashMap<>();
    this.queue = new PriorityQueue<>();
    this.maxGeneratedId = new AtomicInteger(0);
  }

  public int upload(String video) {
    int id = generateId();
    videos.put(id, video);

    return id;
  }

  private int generateId() {
    if (!queue.isEmpty())
      return queue.poll();

    return maxGeneratedId.getAndIncrement();
  }

  public void remove(int videoId) {
    if (videos.containsKey(videoId)) {
      queue.offer(videoId);
      videos.remove(videoId);
    }
  }

  public String watch(int videoId, int startMinute, int endMinute) {
    if (videos.containsKey(videoId)) {
      views.merge(videoId, 1, Integer::sum);
      String video = videos.get(videoId);
      return video.substring(startMinute, Math.min(endMinute + 1, video.length()));
    }
    return String.valueOf(-1);
  }

  public void like(int videoId) {
    if (videos.containsKey(videoId)) {
      likes.merge(videoId, 1, Integer::sum);
    }
  }

  public void dislike(int videoId) {
    if (videos.containsKey(videoId)) {
      dislikes.merge(videoId, 1, Integer::sum);
    }
  }

  public int[] getLikesAndDislikes(int videoId) {
    if (!videos.containsKey(videoId))
      return new int[]{-1};

    return new int[]{likes.getOrDefault(videoId, 0), dislikes.getOrDefault(videoId, 0)};
  }

  public int getViews(int videoId) {
    if (!videos.containsKey(videoId))
      return -1;

    return views.getOrDefault(videoId, 0);
  }
}
