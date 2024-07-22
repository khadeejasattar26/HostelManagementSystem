package FeedBack;

public class Feedback {
    // Private fields for feedback details
    private String feedbackID;
    private String studentID;
    private String comments;
    private int rating;

    // Constructor to initialize feedback object
    public Feedback(String feedbackID, String studentID, String comments, int rating) {
        this.feedbackID = feedbackID;
        this.studentID = studentID;
        this.comments = comments;
        this.rating = rating;
    }

    // Getter for feedbackID
    public String getFeedbackID() {
        return feedbackID;
    }

    // Setter for feedbackID
    public void setFeedbackID(String feedbackID) {
        this.feedbackID = feedbackID;
    }

    // Getter for studentID
    public String getStudentID() {
        return studentID;
    }

    // Setter for studentID
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    // Getter for comments
    public String getComments() {
        return comments;
    }

    // Setter for comments
    public void setComments(String comments) {
        this.comments = comments;
    }

    // Getter for rating
    public int getRating() {
        return rating;
    }

    // Setter for rating
    public void setRating(int rating) {
        this.rating = rating;
    }
}
