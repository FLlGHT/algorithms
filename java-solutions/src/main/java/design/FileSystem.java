package design;

import java.util.*;

/**
 * 588. Design In-Memory File System
 * <p>
 * Design a data structure that simulates an in-memory file system.
 * <p>
 * Implement the FileSystem class:
 * <p>
 * FileSystem() Initializes the object of the system.
 * List<String> ls(String path)
 * If path is a file path, returns a list that only contains this file's name.
 * If path is a directory path, returns the list of file and directory names in this directory.
 * The answer should in lexicographic order.
 * void mkdir(String path) Makes a new directory according to the given path. The given directory path does not exist.
 * If the middle directories in the path do not exist, you should create them as well.
 * void addContentToFile(String filePath, String content)
 * If filePath does not exist, creates that file containing given content.
 * If filePath already exists, appends the given content to original content.
 * String readContentFromFile(String filePath) Returns the content in the file at filePath.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input
 * ["FileSystem", "ls", "mkdir", "addContentToFile", "ls", "readContentFromFile"]
 * [[], ["/"], ["/a/b/c"], ["/a/b/c/d", "hello"], ["/"], ["/a/b/c/d"]]
 * Output
 * [null, [], null, null, ["a"], "hello"]
 * <p>
 * Explanation
 * FileSystem fileSystem = new FileSystem();
 * fileSystem.ls("/");                         // return []
 * fileSystem.mkdir("/a/b/c");
 * fileSystem.addContentToFile("/a/b/c/d", "hello");
 * fileSystem.ls("/");                         // return ["a"]
 * fileSystem.readContentFromFile("/a/b/c/d"); // return "hello"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= path.length, filePath.length <= 100
 * path and filePath are absolute paths which begin with '/' and do not end with '/' except that the path is just "/".
 * You can assume that all directory names and file names only contain lowercase letters,
 * and the same names will not exist in the same directory.
 * You can assume that all operations will be passed valid parameters, and users will not attempt to retrieve file content
 * or list a directory or file that does not exist.
 * <p>
 * 1 <= content.length <= 50
 * At most 300 calls will be made to ls, mkdir, addContentToFile, and readContentFromFile.
 */
public class FileSystem {

  private final FileSystemNode root;

  public FileSystem() {
    Map<String, FileSystemNode> rootNode = new TreeMap<>(Map.of("", FileSystemNode.empty()));
    root = new FileSystemNode(rootNode);
  }

  public List<String> ls(String path) {
    String[] pathParts = toPathParts(path);
    FileSystemNode currentNode = getCurrentNode(pathParts);

    return currentNode.isFile()
      ? lastPathPart(pathParts)
      : currentNode.childrenList();
  }

  public void mkdir(String path) {
    mkdir(path, Optional.empty());
  }

  public void addContentToFile(String filePath, String content) {
    mkdir(filePath, Optional.of(content));
  }

  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  private void mkdir(String path, Optional<String> content) {
    String[] pathParts = toPathParts(path);

    FileSystemNode current = root;
    for (String pathPart : pathParts) {
      if (current.getChildren().containsKey(pathPart)) {
        current = current.getChildren().get(pathPart);
      } else {
        FileSystemNode childrenNode = FileSystemNode.empty();
        current.addChildren(pathPart, childrenNode);
        current = childrenNode;
      }
    }

    content.ifPresent(current::addContent);
  }

  public String readContentFromFile(String filePath) {
    String[] pathParts = toPathParts(filePath);
    FileSystemNode current = getCurrentNode(pathParts);

    return current.getContent();
  }

  private String[] toPathParts(String path) {
    String[] result = path.split("/");
    return result.length == 0 ? new String[]{""} : result;
  }

  private FileSystemNode getCurrentNode(String[] pathParts) {
    FileSystemNode currentNode = root;

    for (String pathPart : pathParts) {
      currentNode = currentNode.getChildren().get(pathPart);
    }
    return currentNode;
  }

  private List<String> lastPathPart(String[] pathParts) {
    return List.of(pathParts[pathParts.length - 1]);
  }

  private static class FileSystemNode {
    private final Map<String, FileSystemNode> children;

    private final StringBuilder content;

    public FileSystemNode(Map<String, FileSystemNode> children) {
      this.children = children;
      this.content = new StringBuilder();
    }

    public static FileSystemNode empty() {
      return new FileSystemNode(new TreeMap<>());
    }

    public Map<String, FileSystemNode> getChildren() {
      return children;
    }

    public List<String> childrenList() {
      return children.keySet().stream().toList();
    }

    public String getContent() {
      return content.toString();
    }

    public void addChildren(String pathPart, FileSystemNode node) {
      children.put(pathPart, node);
    }

    public void addContent(String newContent) {
      content.append(newContent);
    }

    public boolean isFile() {
      return !content.isEmpty();
    }
  }
}
