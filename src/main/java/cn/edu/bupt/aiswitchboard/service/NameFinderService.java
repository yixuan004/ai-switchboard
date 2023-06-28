package cn.edu.bupt.aiswitchboard.service;

import cn.edu.bupt.aiswitchboard.model.NameFinderFindRequest;
import cn.edu.bupt.aiswitchboard.model.NameFinderInsertRequest;
import cn.edu.bupt.aiswitchboard.model.NameFinderUpdateRequest;

public interface NameFinderService {
    Object find(NameFinderFindRequest requestParameters);
    Object insert(NameFinderInsertRequest requestParameters);
    Object update(NameFinderUpdateRequest requestParameters);
}
