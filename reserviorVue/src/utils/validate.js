export function validUsername(str) {
    const valid_map = ['sjl', 'lsy', 'czy', 'lay', 'admin']
    return valid_map.indexOf(str.trim()) >= 0
}