// 添加的地图json数据
import zhejiang from '../json/zj.json'
import hangzhou from '../json/hangz.json'
import huzhou from '../json/huz.json'
import jiaxing from '../json/jiaxing.json'
import jinhua from '../json/jinhua.json'
import lishui from '../json/lishui.json'
import ningbo from '../json/ningbo.json'
import quzhou from '../json/quzhou.json'
import shaoxing from '../json/shaoxing.json'
import taizhou from '../json/taizhou.json'
import wenzhou from '../json/wenzhou.json'
import zhoushan from '../json/zhoushan.json'
// ...

const mapDict = {
  杭州市: 'hangzhou',
  湖州市: 'huzhou',
  嘉兴市: 'jiaxing',
  金华市: 'jinhua',
  丽水市: 'lishui',
  宁波市: 'ningbo',
  衢州市: 'quzhou',
  绍兴市: 'shaoxing',
  台州市: 'taizhou',
  温州市: 'wenzhou',
  舟山市: 'zhoushan'

}

const mapData = {
    hangzhou,
    huzhou,
    jiaxing,
    jinhua,
    lishui,
    ningbo,
    quzhou,
    shaoxing,
    taizhou,
    wenzhou,
    zhoushan
  // ...
}

export function getMap (mapName) {
  const cityName = mapDict[mapName]
  if (cityName) {
    return [cityName, mapData[cityName]]
  }
  return ['zhejiang', zhejiang]
}

