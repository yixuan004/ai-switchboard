namespace java cn.edu.bupt.aiswitchboard.thrift
namespace py aiswitchboard.thrift

service ClassifyService {
  bool ping(),
  i32 classify(1: string name)
}