package dao.reviews;

import dao.common.BaseDaoImpl;
import entity.reviews.ReviewGame;

/**
 * Created by User on 15.06.2017.
 */
public class ReviewGameDaoImpl extends BaseDaoImpl<ReviewGame> {
    public ReviewGameDaoImpl() {
        super(ReviewGame.class);
    }
}
