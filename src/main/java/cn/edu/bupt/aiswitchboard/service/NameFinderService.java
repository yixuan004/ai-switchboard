package cn.edu.bupt.aiswitchboard.service;

import cn.edu.bupt.aiswitchboard.model.NameFinderFindRequest;
import cn.edu.bupt.aiswitchboard.model.NameFinderInsertRequest;

public interface NameFinderService {
    Object find(NameFinderFindRequest requestParameters);
    Object insert(NameFinderInsertRequest requestParameters);
}
