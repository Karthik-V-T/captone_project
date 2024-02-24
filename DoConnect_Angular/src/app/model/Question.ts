import { Topic } from "./Topic";
import { User } from "./User";

export interface Question {
    id?: number;
    questionimage?: string;
    questionname: string;
    topic: Topic;
    user: User;
    qstatus: number;
}